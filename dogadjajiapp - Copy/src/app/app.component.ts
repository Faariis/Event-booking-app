import { Component, OnInit } from '@angular/core';
import { Dogadjaj } from './dogadjaj';
import { DogadjajService } from './dogadjaj.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  public dogadjaji: Dogadjaj[] = [];
  public editDogadjaj: Dogadjaj;
  public deleteDogadjaj: Dogadjaj;

  constructor(private dogadjajService: DogadjajService){}

  ngOnInit() {
    this.getDogadjaj();
  }

  public getDogadjaj(): void {
    this.dogadjajService.getDogadjaj().subscribe({
      next:(response: Dogadjaj[]) => this.dogadjaji = response,
      error:(error:HttpErrorResponse) => {
        alert(error.message);
      }
    });
  }

  public onAddDogadjaj(addForm: NgForm): void {
    document.getElementById('add-employee-form')
    this.dogadjajService.addDogadjaj(addForm.value).subscribe(
      (response: Dogadjaj) => {
        console.log(response);
        this.getDogadjaj();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdateDogadjaj(dogadjaj: Dogadjaj): void {
    this.dogadjajService.updateDogadjaj(dogadjaj).subscribe(
      (response: Dogadjaj) => {
        console.log(response);
        this.getDogadjaj();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public searchDogadjaj(key: string): void {
    const results: Dogadjaj[] = [];
    for (const dogadjaj of this.dogadjaji) {
      if (dogadjaj.naziv.toLowerCase().indexOf(key.toLocaleLowerCase()) !== -1 || dogadjaj.lokacija.toLowerCase().indexOf(key.toLocaleLowerCase()) !== -1) {
        results.push(dogadjaj);
      }
    }
    this.dogadjaji = results;
    if (results.length === 0 || !key) {
      this.getDogadjaj();
    }
  }

  public onOpenModal(dogadjaj: Dogadjaj, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addDogadjajModal');
    }
    if (mode === 'edit') {
      this.editDogadjaj = dogadjaj;
      button.setAttribute('data-target', '#updateDogadjajModal');
    }
    if (mode === 'delete') {
      this.deleteDogadjaj = dogadjaj;
      button.setAttribute('data-target', '#deleteDogadjajModal');
    }
    container?.appendChild(button);
    button.click();
  }

  public onDeleteDogadjaj(dogadjajId: number): void {
    this.dogadjajService.deleteDogadjaj(dogadjajId).subscribe(
      (response: void) => {
        console.log(response);
        this.getDogadjaj();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

}
