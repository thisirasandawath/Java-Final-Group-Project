package net.nsbm.happymeals.controller;

import net.nsbm.happymeals.model.Chef;
import net.nsbm.happymeals.model.Comment;
import net.nsbm.happymeals.model.Food;
import net.nsbm.happymeals.model.Helper;
import net.nsbm.happymeals.model.User;
import net.nsbm.happymeals.service.ChefService;
import net.nsbm.happymeals.service.CommentService;
import net.nsbm.happymeals.service.FoodService;
import net.nsbm.happymeals.service.HelperService;
import net.nsbm.happymeals.service.UserService;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;

@Controller
//@RequestMapping("/customer")
public class CustomerController
{
    private final UserService userService;
    private final FoodService foodService;
    private final CommentService commentService;
    private final ChefService chefService;
    private final HelperService helperService;

    public CustomerController(UserService userService,
                              FoodService foodService,
                              CommentService commentService,
                              ChefService chefService, HelperService helperService) {
        this.userService = userService;
        this.foodService = foodService;
        this.commentService = commentService;
        this.chefService = chefService;
		this.helperService = helperService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping(value = "/profile", method = {RequestMethod.GET, RequestMethod.POST})
    public String showProfilePage(Principal principal, Model model) {

        User user = userService.fetchUserByUsername(principal.getName());
        model.addAttribute("user", user);

        return "customer/Profile";
    }

    @RequestMapping(value = "/profile-modify", method = {RequestMethod.GET, RequestMethod.POST})
    public String showProfileModifyPage(Principal principal, Model model) {

        User user = userService.fetchUserByUsername(principal.getName());
        user.setPassword("");
        model.addAttribute("user", user);

        return "customer/ProfileModify";
    }

    @RequestMapping("/profile-modify-action")
    public String profileModifyAction(@Valid @ModelAttribute("user") User updatedUser,
                                      BindingResult bindingResult,
                                      Principal principal) {

        if (bindingResult.hasFieldErrors("email") || bindingResult.hasFieldErrors("password")
                || bindingResult.hasFieldErrors("phoneNumber")) {
            return "redirect:/profile-modify?error";
        }

        User user = userService.fetchUserByUsername(principal.getName());
        user.setEmail(updatedUser.getEmail());
        user.setPassword(updatedUser.getPassword());
        user.setPhoneNumber(updatedUser.getPhoneNumber());
        userService.updateUser(user);

        return "redirect:/profile?updated";
    }

    @RequestMapping(value = "/payment", method = {RequestMethod.GET, RequestMethod.POST})
    public String showPaymentPage(@RequestParam("foodId") int foodId,
                                  Model model,
                                  HttpSession session) {

        model.addAttribute("food", foodService.findById(foodId));
        session.setAttribute("price", foodService.findById(foodId).getPrice());

        return "customer/Payment";
    }

    @GetMapping("/fetchUserById/{id}")
    User fetchUserById(@PathVariable String id) {
        return userService.fetchUserById(Integer.parseInt(id));
    }


    @RequestMapping(value = "/comments/{foodID}", method = {RequestMethod.GET, RequestMethod.POST})
    public String selectFoodID(@PathVariable("foodID") int foodID,
                               HttpSession session) {

        session.setAttribute("foodID", foodID);
        return "redirect:/comments";
    }

    @RequestMapping(value = "/comments", method = {RequestMethod.GET, RequestMethod.POST})
    public String showCommentPage(Model model, HttpSession session) {

        int foodID = session.getAttribute("foodID") == null ? 1 : (int) session.getAttribute("foodID");
        model.addAttribute("food", foodService.findById(foodID));

        return "customer/Comments";
    }

    @RequestMapping(value = "/post-comments")
    public String postComments(@RequestParam("commentID") int commentID,
                               @RequestParam("comment") String postedComment,
                               Principal principal,
                               HttpSession session) {

        Comment comment = new Comment();

        int foodID = session.getAttribute("foodID") == null ? 1 : (int) session.getAttribute("foodID");

        comment.setComment(postedComment);
        comment.setPostedBy(principal.getName());
        comment.setFoodID(foodID);
        comment.setParentID(commentID);

        commentService.addComment(comment);

        return "redirect:/comments?posted";
    }
    
    @RequestMapping(value = "/chef-modify", method = {RequestMethod.GET, RequestMethod.POST})
    public String showChefModifyPage(Model model ,@RequestParam("id") String id) {

        Chef chef = chefService.fetchChefById(Integer.parseInt(id));
        model.addAttribute("chef", chef);

        return "admin/ChefModify";
    }
    
    @RequestMapping("/chef-modify-action")
    public String chefModifyAction(@Valid @ModelAttribute("chef") Chef updatedChef,
                                      BindingResult bindingResult,
                                      @RequestParam("id") String id) {

        if (bindingResult.hasFieldErrors("name") || bindingResult.hasFieldErrors("phoneNumber")) {
            return "redirect:/chef-modify?error&id="+id;
        }

        Chef chef = chefService.fetchChefById(Integer.parseInt(id));
        chef.setName(updatedChef.getName());
        chef.setPhoneNumber(updatedChef.getPhoneNumber());
        chefService.save(chef);

        return "redirect:/chef-modify?updated&id="+id;
    }
    
    @RequestMapping(value = "/helper-modify", method = {RequestMethod.GET, RequestMethod.POST})
    public String showHelperModifyPage(Model model ,@RequestParam("id") String id) {

        Helper helper = helperService.fetchHelperById(Integer.parseInt(id));
        model.addAttribute("helper", helper);

        return "admin/HelperModify";
    }
    
    @RequestMapping("/helper-modify-action")
    public String helperModifyAction(@Valid @ModelAttribute("helper") Helper updatedHelper,
                                      BindingResult bindingResult,
                                      @RequestParam("id") String id) {

        if (bindingResult.hasFieldErrors("name") || bindingResult.hasFieldErrors("phoneNumber")) {
            return "redirect:/helper-modify?error&id="+id;
        }

        Helper helper = helperService.fetchHelperById(Integer.parseInt(id));
        helper.setName(updatedHelper.getName());
        helper.setPhoneNumber(updatedHelper.getPhoneNumber());
        helperService.save(helper);

        return "redirect:/helper-modify?updated&id="+id;
    }
    
    @RequestMapping(value = "/food-modify", method = {RequestMethod.GET, RequestMethod.POST})
    public String showFoodModifyPage(Model model ,@RequestParam("id") String id) {

        Food food = foodService.findById(Integer.parseInt(id));
        model.addAttribute("food", food);

        return "admin/FoodModify";
    }
    
    @RequestMapping("/food-modify-action")
    public String foodModifyAction(@Valid @ModelAttribute("food") Food updatedFood,
                                      BindingResult bindingResult,
                                      @RequestParam("id") String id) {

        if (bindingResult.hasFieldErrors("category") || bindingResult.hasFieldErrors("title") 
        		|| bindingResult.hasFieldErrors("price") || bindingResult.hasFieldErrors("description")) {
            return "redirect:/food-modify?error&id="+id;
        }

        Food food = foodService.findById(Integer.parseInt(id));
        food.setCategory(updatedFood.getCategory());
        food.setTitle(updatedFood.getTitle());
        food.setPrice(updatedFood.getPrice());
        food.setDescription(updatedFood.getDescription());
        
        foodService.save(food);

        return "redirect:/food-modify?updated&id="+id;
    }
}