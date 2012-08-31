package crf.proyect.proyecto1.persistencia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class CategoryManager {
	CategoryAdapter categoryAdapter;

    public CategoryManager(Context context){
      categoryAdapter = new CategoryAdapter(context);
    }

    public long createCategory(Category category){
      ContentValues categoryContentValues = convertCategoryInContentValues(category);
      return categoryAdapter.createCategory(categoryContentValues);
    }

    public Category getCategoryById(int id){
      Cursor categoryCursor = categoryAdapter.fetchCategory(id);
      return convertCursorInCategory(categoryCursor);
    }

    private ContentValues convertCategoryInContentValues(Category category) {
      ContentValues contentValues = new ContentValues();
      contentValues.put(CategoryAdapter.KEY_ID, category.getId());
      contentValues.put(CategoryAdapter.KEY_NAME, category.getName());
      return contentValues;
    }

    private Category convertCursorInCategory(Cursor cursor) {
      Category category = new Category();
      category.setId(cursor.getInt(cursor.getColumnIndex(CategoryAdapter.KEY_ID)));
      category.setName(cursor.getString(cursor.getColumnIndex(CategoryAdapter.KEY_NAME)));
      cursor.close();
      return category;
    }

}
