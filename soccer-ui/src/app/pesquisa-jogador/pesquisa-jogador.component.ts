import { Component, OnInit } from '@angular/core';
import {JogadorService} from '../service/jogador.service';
import {MenuItem} from 'primeng/api';
import {Jogador} from '../model/model';

@Component({
  selector: 'app-pesquisa-jogador',
  templateUrl: './pesquisa-jogador.component.html',
  styleUrls: ['./pesquisa-jogador.component.css']
})
export class PesquisaJogadorComponent implements OnInit {

  private itens: Jogador[];
  private menuItems: MenuItem[];
  private cols: any[];

  constructor(private jogadorService: JogadorService) { }

  ngOnInit() {
    this.consultar();
    this.buildMenuItems();
    this.buildCols();
  }

  private buildCols() {
    this.cols = [
      { field: 'nome', header: 'Nome' },
      { field: 'email', header: 'E-mail' }
    ];
  }

  private buildMenuItems() {
    this.menuItems = [{
      label: 'Adicionar Jogador',
      icon: 'fa-plus',
      routerLink: ['/jogadores/novo']
    }];
  }

  private consultar() {
    this.jogadorService.listar().subscribe(dados => this.itens = dados);
  }

  excluir(id) {
    this.jogadorService.excluir(id).subscribe(res => {
      this.consultar();
    });
  }

}
