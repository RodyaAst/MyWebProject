import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  public num: number = 0;
  constructor() { }

  ngOnInit(): void {
  }

  public onFocusUp():void {
    this.num+=1;
  }

  public onFocusDown():void {
    this.num-=1;
  }
}
