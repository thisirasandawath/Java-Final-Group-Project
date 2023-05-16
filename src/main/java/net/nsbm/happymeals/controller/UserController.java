package net.nsbm.happymeals.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.nsbm.happymeals.model.Chef;
import net.nsbm.happymeals.model.Food;
import net.nsbm.happymeals.model.Helper;
import net.nsbm.happymeals.model.User;
import net.nsbm.happymeals.service.ChefService;
import net.nsbm.happymeals.service.FoodService;
import net.nsbm.happymeals.service.HelperService;
import net.nsbm.happymeals.service.UserService;

@RestController
@RequestMapping("/api/v1/admin")
public class UserController
{
    private final UserService userService;
    private final FoodService foodService;
    private final ChefService chefService;
    private final HelperService helperService;

    public UserController(UserService userService, FoodService foodService, ChefService chefService,HelperService helperService) {
        this.userService = userService;
        this.foodService = foodService;
		this.chefService = chefService;
		this.helperService = helperService;
    }

    @GetMapping("/fetch-all-users")
    List<User> fetchUsersByUsers() {
        return userService.fetchAllUsers();
    }

    @GetMapping("/fetch-user-by-username/{username}")
    User fetchUserByUsers(@PathVariable String username) {
        return userService.fetchUserByUsername(username);
    }

    @GetMapping("/fetch-user-by-id/{id}")
    User fetchUserById(@PathVariable String id) {
        return userService.fetchUserById(Integer.parseInt(id));
    }

    @GetMapping("/delete-user-by-username/{username}")
    void deleteUserByUsername(@PathVariable String username) {
        userService.deleteUser(username);
    }

    @GetMapping("/delete-user-by-id/{id}")
    void deleteUserById(@PathVariable int id) {
        userService.deleteUserById(id);
    }

    @GetMapping("/disable-user/{id}")
    void disableUser(@PathVariable int id) {
        userService.disableUser(id);
    }

    @GetMapping("/enable-user/{id}")
    void enableUser(@PathVariable int id) {
        userService.enableUser(id);
    }

    @GetMapping("/make-admin/{id}")
    void makeAdmin(@PathVariable int id) {
        userService.makeAdmin(id);
    }

    @GetMapping("/remove-admin/{id}")
    void removeAdmin(@PathVariable int id) {
        userService.removeAdmin(id);
    }

    @GetMapping("/delete-food/{id}")
    void deleteFood(@PathVariable String id) {
        foodService.deleteById(Integer.parseInt(id));
    }

    @PostMapping("/add-user-action")
    String saveUser(@Valid @ModelAttribute(value = "user") User user,
                    BindingResult bindingResult) {

        if (bindingResult.hasErrors())
            return "error";

        if (userService.fetchUserByUsername(user.getUsername()) != null)
            return "duplicate";

        userService.registerUser(user);

        return "added";
    }

    @PostMapping("/add-food-action")
    public String register(@Valid @ModelAttribute(value = "food") Food food,
                           BindingResult bindingResult) {

        if (bindingResult.hasErrors())
            return "error";

        foodService.save(food);

        return "added";
    }
    
    @PostMapping("/add-chef-action")
    public String addFood(@Valid @ModelAttribute(value = "chef") Chef chef,
                           BindingResult bindingResult) {

        if (bindingResult.hasErrors())
            return "error";

        chefService.save(chef);

        return "added";
    }
    
    @GetMapping("/delete-chef/{id}")
    void deleteChef(@PathVariable String id) {
    	chefService.deleteById(Integer.parseInt(id));
    }
    
    @PostMapping("/add-helper-action")
    public String addHelper(@Valid @ModelAttribute(value = "helper") Helper helper,
                           BindingResult bindingResult) {

        if (bindingResult.hasErrors())
            return "error";

        helperService.save(helper);

        return "added";
    }
    
    @GetMapping("/delete-helper/{id}")
    void deleteHelper(@PathVariable String id) {
    	helperService.deleteById(Integer.parseInt(id));
    }

}
