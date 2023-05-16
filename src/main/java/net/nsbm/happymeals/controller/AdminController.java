package net.nsbm.happymeals.controller;

import net.nsbm.happymeals.model.Chef;
import net.nsbm.happymeals.model.Food;
import net.nsbm.happymeals.model.Helper;
import net.nsbm.happymeals.model.User;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/admin")
public class AdminController
{
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping(value = "/dashboard", method = {RequestMethod.GET, RequestMethod.POST})
    public String showDashboardPage() {
        return "admin/Dashboard";
    }

    @RequestMapping(value = "/manage-roles", method = {RequestMethod.GET, RequestMethod.POST})
    public String showManageRolesPage() {
        return "admin/ManageRoles";
    }

    @RequestMapping(value = "/manage-user", method = {RequestMethod.GET, RequestMethod.POST})
    public String showManageUserPage() {
        return "admin/ManageUser";
    }

    @RequestMapping(value = "/add-user", method = {RequestMethod.GET, RequestMethod.POST})
    public String showAddUserPage(@ModelAttribute(value = "user") User user) {
        return "admin/AddUser";
    }

    @RequestMapping(value = "/manage-food", method = {RequestMethod.GET, RequestMethod.POST})
    public String showManageFoodPage() {
        return "admin/ManageFood";
    }

    @RequestMapping(value = "/add-food", method = {RequestMethod.GET, RequestMethod.POST})
    public String showAddFoodPage(@ModelAttribute("food") Food food) {
        return "admin/AddFood";
    }
    
    @RequestMapping(value = "/add-chef", method = {RequestMethod.GET, RequestMethod.POST})
    public String showAddChefPage(@ModelAttribute("chef") Chef chef) {
        return "admin/AddChef";
    }
    
    @RequestMapping(value = "/manage-chef", method = {RequestMethod.GET, RequestMethod.POST})
    public String showManageChefPage() {
        return "admin/ManageChefs";
    } 
    
    @RequestMapping(value = "/add-helper", method = {RequestMethod.GET, RequestMethod.POST})
    public String showAddHelperPage(@ModelAttribute("helper") Helper helper) {
        return "admin/AddHelper";
    }
    
    @RequestMapping(value = "/manage-helper", method = {RequestMethod.GET, RequestMethod.POST})
    public String showManageHelperPage() {
        return "admin/ManageHelpers";
    }

}
