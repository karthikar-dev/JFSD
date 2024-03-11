## **Queries and Output for MongoDB Products table:**


#### 1.	Find all the information about each product:
     
    productDB> db.products.find({})
![img_1.png](Output Screenshots/img_1.png)

#### 2.	Find the product price which are between 400 to 800:
    
    productDB> db.products.find({ product_price: { $gte: 400, $lte: 800 } })
![img_2.png](Output Screenshots/img_2.png)

#### 3.	Find the product price which are not between 400 to 600:??	
    
    productDB> db.products.find({ product_price: { $not: { $gte: 400, $lte: 600 } } })
![img_3.png](Output Screenshots/img_3.png)

#### 4.	List the four products which are greater than 500 in price:
    
    productDB> db.products.find({ product_price: { $gt: 500 } }).limit(4) 
![img_4.png](Output Screenshots/img_4.png)

#### 5.	Find the product name and product material of each product:??	
    
    productDB> db.products.find({}, {product_name: 1, product_material: 1, })
![img_5.png](Output Screenshots/img_5.png)

#### 6.	Find the product with a row id of 10:	
    
    productDB> db.products.findOne({ "id": "10" })
![img_6.png](Output Screenshots/img_6.png)

#### 7.	Find only the product name and product material:

    productDB> db.products.find({}, { product_name: 1, product_material: 1})
![img_7.png](Output Screenshots/img_7.png)

#### 8.	Find all products which contain the value "soft" in product material:
    
    productDB> db.products.find({ product_material: /soft/i })
![img_8.png](Output Screenshots/img_8.png)

#### 9.	Find products which contain product color "indigo" and product price 492.00:

	productDB> db.products.find({product_color: "indigo", product_price: 492.00 })
![img_9.png](Output Screenshots/img_9.png)

#### 10.	Delete the products which product price values are the same:

	productDB> db.products.aggregate([{
        		$group: { id: ?$product_price", count: { $sum: 1 }, ids: { $push: "$_id" }}
    	},{$match: {count: { $gt: 1 }}
   	 }]).forEach(function(doc) {
        		db.products.deleteMany({ "_id": { $in: doc.ids } });
    	});

![img_10.png](Output Screenshots/img_10.png)
![img_11.png](Output Screenshots/img_11.png)
![img_12.png](Output Screenshots/img_12.png)
![img_13.png](Output Screenshots/img_13.png)


