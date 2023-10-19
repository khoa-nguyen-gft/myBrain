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
    studentById: (root, args, context, info) => {
        //args will contain parameter passed in query
        return db.students.get(args.id)
    }

}

const Student = {
    fullName: (root, args, context, info) => {
        return root.firstName + ": " + root.lastName
    }, 
    college: (root, args, context, info) => {
        return db.colleges.get(root.collegeId)
    }
}

const Mutation = {
    createStudent: (root, args, context, info) => {
         const id = db.students.create(
            {
                collegeId: args.collegeId,
                firstName: args.firstName,
                lastName: args.lastName
            }
        )
        return db.students.get(id)
    }
}

module.exports = {Query, Student, Mutation}

