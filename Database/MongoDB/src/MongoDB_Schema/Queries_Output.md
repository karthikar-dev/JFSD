
## **Queries and Output for MongoDB Zen Class Programme:**


#### 1.	Find all the topics and tasks which are taught in the month of October:

    zenDB> db.topics.find({ "month": "October" })

<img width="411" alt="Screenshot 2024-03-19 at 12 45 20 PM" src="https://github.com/karthikar-dev/JFSD/assets/86464165/9a10b8ed-3348-43fc-b064-92f1c670deb6">

    zenDB> db.tasks.find({ "task_date": { $gte: "2020-10-01", $lte: "2020-10-31" } })

<img width="593" alt="Screenshot 2024-03-19 at 12 38 51 PM" src="https://github.com/karthikar-dev/JFSD/assets/86464165/84932ae8-5f7b-4841-85e7-b08f64a20c85">


#### 2.	Find all the company drives which appeared between 15 Oct 2020 and 31 Oct 2020:

    zenDB> db.company_drives.find({ "drive_date": { $gte: "2020-10-15", $lte: "2020-10-31" } })

<img width="656" alt="Screenshot 2024-03-19 at 12 46 26 PM" src="https://github.com/karthikar-dev/JFSD/assets/86464165/4680d30f-39d4-4dd7-98d5-f73349d6ce9b">


#### 3.	Find all the company drives and students who appeared for the placement:

    zenDB> db.company_drives.aggregate([ 
            { $lookup: 
                { 
                    from: "users", 
                    localField: "students_appeared", 
                    foreignField: "_id", 
                    as: "students_appeared_details" 
                } 
            }, 
            { $lookup: 
                { 
                    from: "users", 
                    localField: "students_selected", 
                    foreignField: "_id", 
                    as: "students_selected_details" 
                } 
            }, 
            { $project: 
                { 
                    _id: 1, 
                    drive_name: 1, 
                    drive_date: 1, 
                    students_appeared: "$students_appeared_details", 
                    students_selected: "$students_selected_details" 
                } 
            }] )
<img width="1440" alt="Screenshot 2024-03-19 at 3 23 59 PM" src="https://github.com/karthikar-dev/JFSD/assets/86464165/01eb70b9-a5a9-4d22-9f30-3d8adfc46cb0">



#### 4.	Find the number of problems solved by the user in codekata:

    zenDB> db.codekata.aggregate([
            {
                $group: {
                    _id: "$user_id",
                    total_problems_solved: { $sum: "$problems_solved" }
                }
            },
            {
                $lookup: {
                    from: "users",
                    localField: "_id",
                    foreignField: "_id",
                    as: "user"
                }
            },
            {
                $unwind: "$user"
            },
            {
                $project: {
                    user_id: "$user._id",
                    name: "$user.name",
                    total_problems_solved: 1
                }
            }
        ])

<img width="613" alt="Screenshot 2024-03-19 at 3 28 30 PM" src="https://github.com/karthikar-dev/JFSD/assets/86464165/e0076696-c49b-4063-9d2c-42ed97e77d19">


#### 5.	Find all the mentors who have a mentee count more than 15:

    zenDB> db.mentors.find({ "mentee_count": { $gt: 15 } })

<img width="481" alt="Screenshot 2024-03-19 at 3 32 29 PM" src="https://github.com/karthikar-dev/JFSD/assets/86464165/1ab36a02-1f2d-41d3-bcf0-6351039a1363">

#### 6.	Find the number of users who are absent and task is not submitted between 15 Oct 2020 and 31 Oct 2020:

    zenDB> db.attendance.aggregate([
        {
            $lookup: {
                from: "tasks",
                localField: "user_name",
                foreignField: "user_submissions.user_name",
                as: "user_tasks"
            }
        },
        {
            $match: {
                "date": { $gte: "2020-10-15", $lte: "2020-10-31" },
                "status": "absent",
                "user_tasks": { $size: 0 }
            }
        },
        {
            $count: "users_count"
        }
    ])
    
<img width="599" alt="Screenshot 2024-03-19 at 3 36 17 PM" src="https://github.com/karthikar-dev/JFSD/assets/86464165/01032a57-0151-4999-bc7c-5f68d9d106d1">









