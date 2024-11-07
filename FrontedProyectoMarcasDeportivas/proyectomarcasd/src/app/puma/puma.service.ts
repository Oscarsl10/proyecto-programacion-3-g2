import { Injectable } from '@angular/core';
import { map, Observable, of } from 'rxjs';
import { MarcasDeportivasc } from '../marcas_deportivas/marcas-deportivasc';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PumaService {

  private urlEndPoint:string='http://localhost:8080/api/puma'
  private httpHeaders = new HttpHeaders({'content-Type': 'application/json'})

  constructor(private http:HttpClient) { }

  //buscar tareas de la base de datos
  getPuma():Observable<MarcasDeportivasc[]>{
    
    //return of (MarcasDeportivasc);
    return this.http.get(this.urlEndPoint).pipe(
     map((response)=> response as MarcasDeportivasc[])
    )
   }

  create(puma:MarcasDeportivasc): Observable<MarcasDeportivasc>{
    return this.http.post<MarcasDeportivasc>(this.urlEndPoint,puma, {headers:this.httpHeaders})
  }

  //Método de editar tarea
  getPumaa(id: any):Observable<MarcasDeportivasc>{
    return this.http.get<MarcasDeportivasc>(`${this.urlEndPoint}/${id}`)
  }

  //Edición final
  update(puma: MarcasDeportivasc):Observable<MarcasDeportivasc>{
    return this.http.put<MarcasDeportivasc>(`${this.urlEndPoint}/${puma.id}`, puma, {headers:this.httpHeaders})
  }

  //Eliminar
  delete(id:number):Observable<MarcasDeportivasc>{
    return this.http.delete<MarcasDeportivasc>(`${this.urlEndPoint}/${id}`, {headers:this.httpHeaders})
  }
}