# api_sample


http://localhost:8080/graphiql

query bookDetails {
  bookById(id: 1) {
    id
    name
    pageCount
    author {
      id
      firstName
      lastName
    }
  }
}