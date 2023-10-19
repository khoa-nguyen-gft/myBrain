const db = require('./db')

const Query = {
    test: () => 'Test Success, GraphQL server is up & running !!',

    //resolver function for greeting
    greeting: () => {
        return "Greeting"
    },

    //resolver function for students returns list
    students: () => db.students.list(),

    //resolver function for studentbyId
    StudentById: (args) => {
        //args will contain parameter passed in query
        return db.students.get(args.id)
    }

}

const Student = {
    fullName: (root) => {
        return root.firstName + ": " + root.lastName
    }, 
    college: (root) => {
        return db.colleges.get(root.collegeId)
    }
}


module.exports = {Query, Student}

