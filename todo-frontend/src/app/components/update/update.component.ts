import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { Todo } from "src/app/models/Todo";
import { TodoService } from "src/app/services/todo.service";

@Component({
  selector: "app-update",
  templateUrl: "./update.component.html",
  styleUrls: ["./update.component.css"],
})
export class UpdateComponent implements OnInit {
  todo: Todo = {
    title: "",
    description: "",
    dateToFinish: new Date(),
    finished: false,
  };

  constructor(
    private router: Router,
    private service: TodoService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.todo.id = this.route.snapshot.paramMap.get("id")!;
    this.findById();
  }

  update(): void {
    this.formatDate();
    this.service.update(this.todo).subscribe(
      (response) => {
        this.service.message(`Task update successfully`);
        this.router.navigate([""]);
      },
      (err) => {
        this.service.message(`Failed to update task`);
        this.router.navigate([""]);
      }
    );
  }

  findById(): void {
    this.service.findById(this.todo.id).subscribe((response) => {
      this.todo = response;
    });
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
