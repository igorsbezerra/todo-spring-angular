import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { Todo } from "src/app/models/Todo";
import { TodoService } from "src/app/services/todo.service";

@Component({
  selector: "app-read-all",
  templateUrl: "./read-all.component.html",
  styleUrls: ["./read-all.component.css"],
})
export class ReadAllComponent implements OnInit {
  closed = 0;
  list: Todo[] = [];
  listFinished: Todo[] = [];

  constructor(private service: TodoService, private router: Router) {}

  ngOnInit(): void {
    this.findAll();
  }

  findAll(): void {
    this.service.findAll().subscribe((items) => {
      items.forEach((todo) => {
        if (todo.finished) {
          this.listFinished.push(todo);
        } else {
          this.list.push(todo);
        }
      });
      this.closed = this.listFinished.length;
    });
  }

  finishTask(item: Todo): void {
    item.finished = true;
    this.service.update(item).subscribe(() => {
      this.service.message(`Task completed successfully!`);
      this.list = this.list.filter((todo) => todo.id !== item.id);
      this.closed++;
    });
  }

  delete(id: any): void {
    this.service.delete(id).subscribe((response) => {
      if (response === null) {
        this.service.message(`Task deleted successfully!`);
        this.list = this.list.filter((todo) => todo.id !== id);
      }
    });
  }

  navigateToFinished(): void {
    this.router.navigate(["finalized"]);
  }
}
