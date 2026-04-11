package storeapp.repository;
import storeapp.domain.Category;
import java.util.ArrayList;
import java.util.List;
public class CategoryRepository {

  private  List <Category> categories = new ArrayList<>();
  public CategoryRepository(){
      categories.add(new Category(1 , "Ropa" , true ));
      categories.add(new Category(2 , "Calzado" , true ));
      categories.add(new Category(3 , "Accesorios" , true ));
      categories.add(new Category(4 , "Electronicos" , true ));
      categories.add(new Category(5 , "Hogar" , true ));
  }

  public List<Category> findAllCatagories(){
      return categories;
  }
  public Category findCategoryById(int id){
      for(Category category : categories){
          if(category.getIdCategory()==id){
              return category;
          }
      }
      return null;

  }
  public Category updateCategory (Category category){
      for (int i = 0; i < categories.size(); i++) {
          if (categories.get(i).getIdCategory()==category.getIdCategory()){
              categories.set(i, category);
              return category;


          }
      }
      return null;

  }











}
