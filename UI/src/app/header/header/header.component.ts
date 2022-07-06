import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  public num: number = 0;
  public underText: string = "";

  constructor() { }

  ngOnInit(): void {
  }

  public onFocusUp():void {
    this.num+=1;
    this.underText = "text-underline";
  }

  public onFocusDown():void {
    this.num-=1;
    this.underText = "";
  }
}
