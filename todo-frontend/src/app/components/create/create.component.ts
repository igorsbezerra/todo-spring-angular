import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { Todo } from "src/app/models/Todo";
import { TodoService } from "src/app/services/todo.service";

@Component({
  selector: "app-create",
  templateUrl: "./create.component.html",
  styleUrls: ["./create.component.css"],
})
export class CreateComponent implements OnInit {
  todo: Todo = {
    title: "",
    description: "",
    dateToFinish: new Date(),
    finished: false,
  };

  constructor(private router: Router, private service: TodoService) {}

  ngOnInit(): void {}

  create(): void {
    this.formatDate();
    this.service.create(this.todo).subscribe(
      (response) => {
        this.service.message(`Task create successfully`);
        this.router.navigate([""]);
      },
      (err) => {
        this.service.message(`Failed to create task`);
        this.router.navigate([""]);
      }
    );
  }

  cancel(): void {
    this.router.navigate([""]);
  }

  formatDate(): void {
    this.todo.dateToFinish = new Date(
      this.todo.dateToFinish
    ).toLocaleDateString("pt-br");
  }
}
