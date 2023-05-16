package net.nsbm.happymeals.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "Foods")
public class Food
{
    @Id
    @Column(name = "Food_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int foodID;

    @NotNull
    @Column(name = "Category")
    private String category;

    @NotNull
    @Size(min = 5, max = 30)
    @Column(name = "Title")
    private String title;

    @NotNull
    @Size(min = 4, max = 500)
    @Column(name = "Description", columnDefinition="TEXT")
    private String description;

    @NotNull
    @Min(50)
    @Max(10_000)
    @Column(name = "Price")
    private int price;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "Food_ID")
    private List<Comment> comments;

	public int getFoodID() {
		return foodID;
	}

	public void setFoodID(int foodID) {
		this.foodID = foodID;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
    
    
}
