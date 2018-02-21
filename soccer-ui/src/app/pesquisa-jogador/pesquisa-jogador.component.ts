import { Component, OnInit } from '@angular/core';
import {JogadorService} from '../service/jogador.service';
import {MenuItem} from 'primeng/api';

@Component({
  selector: 'app-pesquisa-jogador',
  templateUrl: './pesquisa-jogador.component.html',
  styleUrls: ['./pesquisa-jogador.component.css']
})
export class PesquisaJogadorComponent implements OnInit {

  itens = [];
  private menuItems: MenuItem[];

  constructor(private jogadorService: JogadorService) { }

  ngOnInit() {
    this.consultar();
    this.buildMenuItems();
  }

  private buildMenuItems() {
    this.menuItems = [{
      label: 'Adicionar Jogador',
      icon: 'fa-plus',
      routerLink: ['/jogadores/novo']
    }];
  }

  private consultar() {
    this.jogadorService.listar().subscribe(dados => this.itens = dados.sort((a, b) => (a.nome > b.nome ? 1 : -1)));
  }

  excluir(id) {
    this.jogadorService.excluir(id).subscribe(res => {
      this.consultar();
    });
  }

}
