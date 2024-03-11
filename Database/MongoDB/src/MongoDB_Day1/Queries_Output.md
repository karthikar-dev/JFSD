## **Queries and Output for MongoDB Products table:**


#### 1.	Find all the information about each product:
     
    productDB> db.products.find({})
![image](https://github.com/karthikar-dev/JFSD/assets/86464165/a5525f65-03a2-4b80-9309-d7dcc5031eff)


#### 2.	Find the product price which are between 400 to 800:
    
    productDB> db.products.find({ product_price: { $gte: 400, $lte: 800 } })
![image](https://github.com/karthikar-dev/JFSD/assets/86464165/ba9291ee-8dca-46e6-a4dc-20d9a189a47d)


#### 3.	Find the product price which are not between 400 to 600:??	
    
    productDB> db.products.find({ product_price: { $not: { $gte: 400, $lte: 600 } } })
![image](https://github.com/karthikar-dev/JFSD/assets/86464165/c00ff9c2-c294-4e9f-9a36-89e253a20ac4)


#### 4.	List the four products which are greater than 500 in price:
    
    productDB> db.products.find({ product_price: { $gt: 500 } }).limit(4) 
![image](https://github.com/karthikar-dev/JFSD/assets/86464165/06def511-77db-4735-9af9-c8504079f2d0)


#### 5.	Find the product name and product material of each product:??	
    
    productDB> db.products.find({}, {product_name: 1, product_material: 1, })
![image](https://github.com/karthikar-dev/JFSD/assets/86464165/c0a63a03-8cac-4c1d-aea3-ac75caade0e6)


#### 6.	Find the product with a row id of 10:	
    
    productDB> db.products.findOne({ "id": "10" })
<img width="371" alt="image" src="https://github.com/karthikar-dev/JFSD/assets/86464165/15c61474-eff7-4ae5-9db0-7b10124520af">


#### 7.	Find only the product name and product material:

    productDB> db.products.find({}, { product_name: 1, product_material: 1})
![image](https://github.com/karthikar-dev/JFSD/assets/86464165/5a6c3b64-d521-4fbd-8a6d-9c6ccf0032a9)


#### 8.	Find all products which contain the value "soft" in product material:
    
    productDB> db.products.find({ product_material: /soft/i })
![image](https://github.com/karthikar-dev/JFSD/assets/86464165/95d964ed-d472-453e-9cce-b5388d78abb9)


#### 9.	Find products which contain product color "indigo" and product price 492.00:

	productDB> db.products.find({product_color: "indigo", product_price: 492.00 })
![image](https://github.com/karthikar-dev/JFSD/assets/86464165/c56e490d-5cb9-48d7-ac41-3070d4d9db80)


#### 10.	Delete the products which product price values are the same:

	productDB> db.products.aggregate([{
        		$group: { id: ?$product_price", count: { $sum: 1 }, ids: { $push: "$_id" }}
    	},{$match: {count: { $gt: 1 }}
   	 }]).forEach(function(doc) {
        		db.products.deleteMany({ "_id": { $in: doc.ids } });
    	});

![image](https://github.com/karthikar-dev/JFSD/assets/86464165/bf343185-d466-41a8-9c97-6daa25180e90)
![image](https://github.com/karthikar-dev/JFSD/assets/86464165/ce48c456-e7c5-4466-8c83-bd63743edb72)
![image](https://github.com/karthikar-dev/JFSD/assets/86464165/5f8e3073-d9b2-4852-8046-9859a51d026d)
![image](https://github.com/karthikar-dev/JFSD/assets/86464165/ad58ed54-a6ef-40ea-a698-34676fd3779d)



