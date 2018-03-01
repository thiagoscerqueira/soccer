import { Component, OnInit } from '@angular/core';
import {MessageService} from 'primeng/components/common/messageservice';

@Component({
  selector: 'app-pizza-chart',
  templateUrl: './pizza-chart.component.html',
  styleUrls: ['./pizza-chart.component.css']
})
export class PizzaChartComponent implements OnInit {

  labels: string;
  values: string;
  chartData: any;

  constructor(private messageService: MessageService) { }

  ngOnInit() {
    this.labels = 'Valor1,Valor2,Valor3';
    this.values = '10,20,30';
    this.atualizaChart();
  }

  getRandomColor() {
    const letters = '0123456789ABCDEF'.split('');
    let color = '#';
    for (let i = 0; i < 6; i++ ) {
      color += letters[Math.floor(Math.random() * 16)];
    }
    return color;
  }

  atualizaChart() {
    const backgroundColor: string[] = [];
    const labels = this.labels.split(',');
    const data = this.values.split(',');

    labels.forEach(item => backgroundColor.push(this.getRandomColor()));

    this.chartData = {
      labels: labels,
      datasets: [
        {
          data: data,
          backgroundColor: backgroundColor,
          hoverBackgroundColor: backgroundColor
        }
      ]

    };
  }

  onSelect(event) {
    const msg = `Selecionado - Label:${this.labels.split(',')[event.element._index]},Valor:${this.values.split(',')[event.element._index]}`;
    this.messageService.add({severity: 'success', summary: msg});
  }

}
