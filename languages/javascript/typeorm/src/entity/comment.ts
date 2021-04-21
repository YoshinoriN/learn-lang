import {Entity, PrimaryGeneratedColumn, Column} from "typeorm";

@Entity("comments")
export class Comments {

  @PrimaryGeneratedColumn()
  id: number;

  @Column("user_name")
  user_name: string;

  @Column("comment")
  comment: string;

  @Column("created_at")
  created_at: number;

}
