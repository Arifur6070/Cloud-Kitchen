Backend implementation of an online restaurent



Use this format to make post request

{
  "userId": "3",
  "orderDateTime": "2024-05-18T12:00:00",
  "foodOrderItems": [
    {
      "foodItem": {
        "itemId":"6",
        "name": "Beef Biriyani",
        "price": 10.5,
        "mealType": "LUNCH",
        "imagePath": "/images/20240518_184137_Beef_Biriyani.jpg",
        "rating": 4.5
      },
      "quantity": 2
    },
    {
      "foodItem": {
          "itemId":"5",
        "name": "Mutton Biriyani",
        "price": 11.5,
        "mealType": "LUNCH",
        "imagePath": "/images/20240518_184118_Mutton_Biriyani.jpg ",
        "rating": 4.5
      },
      "quantity": 1
    }
  ],
  "drinksOrderItems": [
    {
      "drink": {
        "drinkId":"14",
        "drinkName": "Coke Normal",
        "drinkPrice": 4.5,
        "stock": 100,
        "imagePath": "/images/20240518_181550_Coke_Normal.png"
      },
      "quantity": 3
    },
    {
      "drink": {
        "drinkId":"13",
        "drinkName": "Coke Light",
        "drinkPrice": 4.5,
        "stock": 100,
        "imagePath": "/images/orange_juice.jpg"
      },
      "quantity": 1
    }
  ]
}

