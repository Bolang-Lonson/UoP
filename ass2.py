Item_1 = 200.0
Item_2 = 400.0
Item_3 = 600.0

def purchase(*items):
    match len(items):
        case 1:
            return items[0]

        case 2:
            cost = 0
            for i in items:
                cost += i

            return 0.9 * cost

        case 3:
            cost = 0
            for i in items:
                cost += i

            return 0.75 * cost
        
        case _:
            return None
        

print('Item 1\t\t', purchase(Item_1))
print('Item 2\t\t', purchase(Item_2))
print('Item 3\t\t', purchase(Item_3))
print('Combo 1(Item 1 + 2)\t\t', purchase(Item_1, Item_2))
print('Combo 2(Item 2 + 3)\t\t', purchase(Item_2, Item_3))
print('Combo 3(Item 1 + 3)\t\t', purchase(Item_1, Item_3))
print('Combo 4(Item 1 + 2 + 3)\t\t', purchase(Item_1, Item_2, Item_3))