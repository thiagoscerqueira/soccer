import {Jogador} from './Jogador';

export class Pagamento {
  mes: Date;
  jogador: Jogador;
  valor: number;
  dataInclusao: Date;
  id: string;

  constructor(id: string, mes: Date, jogador: Jogador, valor: number) {
    this.id = id;
    this.mes = mes;
    this.jogador = jogador;
    this.valor = valor;
    this.dataInclusao = new Date();
  }
}
