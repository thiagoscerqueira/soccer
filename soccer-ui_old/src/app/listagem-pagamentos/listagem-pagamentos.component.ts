import { Component, OnInit } from '@angular/core';
import {PagamentoService} from './PagamentoService';
import {Pagamento} from '../model/Pagamento';
import {Jogador} from '../model/Jogador';
import {JogadorService} from './JogadorService';

@Component({
  selector: 'app-listagem-pagamentos',
  templateUrl: './listagem-pagamentos.component.html',
  styleUrls: ['./listagem-pagamentos.component.css']
})
export class ListagemPagamentosComponent implements OnInit {

  pagamentos: Pagamento[] = [];
  service: PagamentoService;
  jogadorService: JogadorService;
  pagamento: Pagamento;
  displayDialog: boolean;

  constructor(service: PagamentoService, jogadorService: JogadorService) {
    this.service = service;
    this.jogadorService = jogadorService;
  }

  ngOnInit() {
    this.jogadorService.limpar();
    this.service.limpar();
    this.jogadorService.salvar(new Jogador('Thiago'));
    this.jogadorService.salvar(new Jogador('Theo'));
  }

  pesquisaPagamentos($event) {
    this.pagamentos = this.service.pesquisar($event.data);
  }

  aoSelecionarPagamento(event) {
    console.log(this.pagamento);
    console.log(event);
    this.displayDialog = true;
  }

  salvaPagamento() {
    this.service.salvar(this.pagamento);
  }
}
