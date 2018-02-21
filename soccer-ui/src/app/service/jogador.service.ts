import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class JogadorService {

  jogadorUrl = 'http://localhost:8080/jogadores';

  constructor(private http: HttpClient) { }

  listar() {
    return this.http.get<any>(this.jogadorUrl);
  }

  excluir(id) {
    console.log(id);
    return this.http.delete(this.jogadorUrl + '/' + id);
  }

  adicionar(item: any) {
    return this.http.post(this.jogadorUrl, item);
  }

  alterar(id, item: any) {
    return this.http.put(this.jogadorUrl + '/' + id, item);
  }

  consultar(id) {
    return this.http.get<any>(this.jogadorUrl + '/' + id);
  }

}
