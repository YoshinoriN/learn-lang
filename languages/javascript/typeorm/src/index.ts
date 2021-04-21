import {createConnection} from "typeorm";
import { Comments } from "./entity/comment";

const connection = createConnection({
  type: "mysql",
  host: "localhost",
  port: 3306,
  username: "root",
  password: "pass",
  database: "cahsper",
  synchronize: false,
  entities: [
    "src/entity/*.js"
  ],

});

connection.then(async connection => {
  /*
  const comments = new Comments();
  comments.id = 12345;
  comments.user_name = "ExampleUser";
  comments.comment = "hogege";
  comments.created_at = 1234567890

  await connection.manager.save(comments);
  */

  await connection
    .createQueryBuilder()
    .insert()
    .into(Comments)
    .values([
      { id: 12346, user_name: "ExampleUser2", comment: "fugaga", created_at: 999997 },
      { id: 12347, user_name: "ExampleUser3", comment: "fugaga", created_at: 999998 },
      { id: 12348, user_name: "ExampleUser4", comment: "papipu", created_at: 999999 }
    ]).execute();

}).catch(error => {
  console.log(error)
});
