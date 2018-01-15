import {Component, OnInit, Output, EventEmitter} from '@angular/core';

@Component({
  selector: 'app-seletor-mes',
  templateUrl: './seletor-mes.component.html',
  styleUrls: ['./seletor-mes.component.css']
})
export class SeletorMesComponent implements OnInit {

  data: Date;
  @Output() acao = new EventEmitter();

  constructor() {
    this.data = new Date();
    this.data.setDate(1);
    this.data.setHours(10);
    this.data.setMinutes(0);
    this.data.setSeconds(0);
    this.data.setMilliseconds(0);
  }

  ngOnInit() {
    this.acao.emit({data: this.data});
  }

  adiciona() {
    if (this.data.getMonth() === 11) {
      this.data.setMonth(0);
      this.data.setFullYear(this.data.getFullYear() + 1);
      return;
    }

    this.data.setMonth(this.data.getMonth() + 1);
    this.data.setDate(1);
    this.acao.emit({data: this.data});
  }

  subtrai() {
    if (this.data.getMonth() === 0) {
      this.data.setMonth(11);
      this.data.setFullYear(this.data.getFullYear() - 1);
      return;
    }

    this.data.setMonth(this.data.getMonth() - 1);
    this.data.setDate(1);
    this.acao.emit({data: this.data});
  }

  mesPorExtenso(): string {
    const meses: Array<string> =
      ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho',
        'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'];

     return meses[this.data.getMonth()];
  }


}
