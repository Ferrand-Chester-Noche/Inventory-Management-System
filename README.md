# Inventory-Management-System
Developers: Ferrand Noche, Abram Dorado, Currie Pariñas

## Overview

This project aims to create an Inventory Management System for a small restaurant. The restaurant offers a variety of menu items, such as appetizers, main courses, side dishes/snacks, desserts, drinks/beverages/alcohol, and merchandise. Due to the extensive range of items they offer, they need a system to manage their inventory effectively, keeping track of stock levels and allowing for bulk purchases when items run low. This system will help them maintain accurate records of their inventory.

Menu items may consist of multiple ingredients, and the system should enable users to view descriptions and characteristics of these ingredients.

## Specifications

1. **Graphical User Interface (GUI):**
   - The system should provide a user-friendly GUI using JavaFX.
   - The GUI should have an intuitive design and be easy to use.
   - The GUI should be professional and presentable.

2. **Inventory Management:**
   - Users should be able to view the list of inventory.
   - Users should be able to add menu items or ingredients to the inventory with item descriptions and specify their category.
   - Users should be able to delete items or ingredients from the inventory.
   - Users should be able to add item/ingredient usage to the inventory, which updates the remaining stock.
  
3. **Import Functionality:**
   - Users should be able to bulk add inventory using .csv files.

4. **SKU (Stock Keeping Unit):**
   - Each item added to the inventory should have a unique SKU generated automatically by the system.
   - The SKU format should follow the pattern: [Category-Abbreviation][Item-Abbreviation]-[Random Number]. Example: CTST-0918 for Condiment: Salt.
   - Users should have the option to input the SKU to automatically populate existing item information in the system, allowing manual input of the restocked quantity and other necessary fields.

### Storage System

The project should implement a storage system for data storage. Options include using CSV or JSON formatted files or a SQL database.

## Other Features 

1. **Export Functionality:** Allow users to export the current inventory stock as a .csv file.
2. **Image Integration:** Enable users to add and display images for items (this feature should not be available for bulk item imports).
