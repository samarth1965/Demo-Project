import { Component, OnInit } from '@angular/core';
import { RouterModule } from '@angular/router';
import { FoodResponse } from '../../model/food-response';
import { FoodServiceService } from '../../services/food-service.service';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [RouterModule,CommonModule,ReactiveFormsModule,FormsModule],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent implements OnInit{

  foods: FoodResponse[] = [];
  searchInput: string='';

  constructor(private foodService: FoodServiceService){}
  ngOnInit(): void {
    throw new Error('Method not implementedssss.');
  }

  // searchByFoodName(){

  // }hello


}
