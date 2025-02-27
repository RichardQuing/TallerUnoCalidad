class Meal:
    def __init__(self):
        self.items = []

    def add(self, item):
        self.items.append(item)

    def get_total_cost(self):
        return sum(item.get_cost() for item in self.items)
    
    def __str__(self):
        text = "Meal: "
        text += "\n".join(str(item) for item in self.items)
        text += "\nTotal cost: " + str(self.get_total_cost())
        return text
    
class Item:
    def __init__(self, name, cost):
        self.name = name
        self.cost = cost

    def get_cost(self):
        return self.cost
    
    def __str__(self):
        return f"{self.name}: {self.cost}"
    
class MealBuilder:
    def __init__(self):
        self.meal = Meal()

    def add_main_item(self):
        pass

    def add_side_item(self):
        pass

    def add_drink_item(self):
        pass

    def add_dessert_item(self):
        pass

    def reset(self):
        self.meal = Meal()

    def get_meal(self):
        return self.meal
    
class StandardMealBuilder(MealBuilder):
    def add_main_item(self):
        self.meal.add(Item("Hamburgesa de Res", 5.99))

    def add_side_item(self):
        self.meal.add(Item("Aros de Cebolla", 2))

    def add_drink_item(self):
        self.meal.add(Item("Coca-Cola", 1.99))

    def add_dessert_item(self):
        self.meal.add(Item("Tiramisu", 3.99))

class VegetarianMealBuilder(MealBuilder):

    def add_main_item(self):
        self.meal.add(Item("Hamburgesa de Vegetales", 4.99))

    def add_side_item(self):
        self.meal.add(Item("Aros de Cebolla", 2))

    def add_drink_item(self):
        self.meal.add(Item("Agua", 1.99))

    def add_dessert_item(self):
        self.meal.add(Item("Fruta", 2.99))

class MealDirector:
    def __init__(self, builder):
        self.builder = builder

    def construct_meal(self):
        self.builder.reset()
        self.builder.add_main_item()
        self.builder.add_side_item()
        self.builder.add_drink_item()
        self.builder.add_dessert_item()

    def construct_main_with_drimk(self):
        self.builder.reset()
        self.builder.add_main_item()
        self.builder.add_drink_item()

standard_builder = StandardMealBuilder()
standard_director = MealDirector(standard_builder)
standard_director.construct_meal()
print(standard_builder.get_meal())

vegetarian_builder = VegetarianMealBuilder()
vegetarian_director = MealDirector(vegetarian_builder)
vegetarian_director.construct_meal()
print(vegetarian_builder.get_meal())