
## **Queries and Output for MongoDB Zen Class Programme:**


#### 1.	Find all the topics and tasks which are taught in the month of October:

    zenDB> db.topics.find({ "month": "October" })
    zenDB> db.tasks.find({ "task_date": { $gte: "2020-10-01", $lte: "2020-10-31" } })
![image](https://github.com/karthikar-dev/JFSD/assets/86464165/a5525f65-03a2-4b80-9309-d7dcc5031eff)


#### 2.	Find all the company drives which appeared between 15 Oct 2020 and 31 Oct 2020:

    zenDB> db.company_drives.find({ "drive_date": { $gte: "2020-10-15", $lte: "2020-10-31" } })
![image](https://github.com/karthikar-dev/JFSD/assets/86464165/ba9291ee-8dca-46e6-a4dc-20d9a189a47d)


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
![image](https://github.com/karthikar-dev/JFSD/assets/86464165/c00ff9c2-c294-4e9f-9a36-89e253a20ac4)


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
![image](https://github.com/karthikar-dev/JFSD/assets/86464165/06def511-77db-4735-9af9-c8504079f2d0)


#### 5.	Find all the mentors who have a mentee count more than 15:

    zenDB> db.mentors.find({ "mentee_count": { $gt: 15 } })
![image](https://github.com/karthikar-dev/JFSD/assets/86464165/c0a63a03-8cac-4c1d-aea3-ac75caade0e6)


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









