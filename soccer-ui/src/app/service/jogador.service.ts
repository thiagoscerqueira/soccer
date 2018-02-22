import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Jogador} from '../model/model';

@Injectable()
export class JogadorService {

  jogadorUrl = 'http://localhost:8081/jogadores';

  constructor(private http: HttpClient) { }

  listar() {
    return this.http.get<Jogador>(this.jogadorUrl);
  }

  excluir(id) {
    console.log(id);
    return this.http.delete(`${this.jogadorUrl}/${id}`);
  }

  adicionar(item: Jogador) {
    return this.http.post(this.jogadorUrl, item);
  }

  alterar(item: Jogador) {
    return this.http.put(`${this.jogadorUrl}/${item.id}`, item);
  }

  consultar(id) {
    return this.http.get<Jogador>(`${this.jogadorUrl}/${id}`);
  }

}
