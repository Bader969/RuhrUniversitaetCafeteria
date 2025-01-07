package service;

import domain.Menu;
import domain.Product;
import repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;

    public void createMenu(Menu menu) {
        menuRepository.save(menu);
    }

    public Menu findMenuById(Long id) {
        return menuRepository.findById(id).orElse(null);
    }

    public void addProductToMenu(Long menuId, Product product) {
        Menu menu = findMenuById(menuId);
        if (menu != null) {
            menu.addProduct(product);
            menuRepository.save(menu);
        }
    }



    public void removeProductFromMenu(Long menuId, Product product) {
        Menu menu = findMenuById(menuId);
        if (menu != null) {
            menu.removeProduct(product);
            menuRepository.save(menu);
        }
    }
}
