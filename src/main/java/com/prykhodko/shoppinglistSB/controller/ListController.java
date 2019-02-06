package com.prykhodko.shoppinglistSB.controller;


import com.prykhodko.shoppinglistSB.exception.ResourceNotFoundException;
import com.prykhodko.shoppinglistSB.model.ListItems;
import com.prykhodko.shoppinglistSB.repository.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api") //declares that the url for all the apis in this controller will start with /api
public class ListController {

    @Autowired
    ListRepository listRepository;

    /**
     * Gets All Items from the Shopping List
     * @return the entire ShoppingList
     */
    @GetMapping("/items")
    public List<ListItems> getAllNotes() {
        return listRepository.findAll(); //calls JpaRepository’s findAll()
    }

    /**
     * Creates a new Item
     * @param item should be saved in the DB
     * @return 400 BadRequest error to the client if the request body with no title
     */
    @PostMapping("/items")
    //The @RequestBody annotation is used to bind the request body with a method parameter
    //The @Valid annotation makes sure that the request body is valid
    //If the request body doesn’t have a title or a content, then spring will return a
    // 400 BadRequest error to the client

    public ListItems createNote(@Valid @RequestBody ListItems item) {
        return listRepository.save(item);
    }

    /**
     * Gets a Single Item
     * Method are throw a ResourceNotFoundException whenever an item with the given id is not found.
     * @param itemId
     * @return
     */

    @GetMapping("/items/{id}")
    //The @PathVariable annotation used to bind a path variable with a method parameter
    public ListItems getNoteById(@PathVariable(value = "id") Long itemId) {
        return listRepository.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("Item", "id", itemId));
    }

    /**
     * Updates an Item
     * @param itemId
     * @param itemDetails
     * @return
     */

    @PutMapping("/items/{id}")
    public ListItems updateNote(@PathVariable(value = "id") Long itemId,
                           @Valid @RequestBody ListItems itemDetails) {

        ListItems item = listRepository.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("Item", "id", itemId));

        item.setItem(itemDetails.getItem());
        item.setDetails(itemDetails.getDetails());
        item.setAmount(itemDetails.getAmount());
        item.setPrice(itemDetails.getPrice());

        ListItems updatedItem = listRepository.save(item);
        return updatedItem;
    }



    /**
     * Deletes an Item
     * @param itemId
     * @return
     */
    @DeleteMapping("/items/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long itemId) {
        ListItems item = listRepository.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("Item", "id", itemId));

        listRepository.delete(item);

        return ResponseEntity.ok().build();
    }
}
