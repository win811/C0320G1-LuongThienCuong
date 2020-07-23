import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class YoutubeService {
    playlist = [
        {id: '0PHQcnbE0N0', song: "Irelia China Combo Không Một Động Tác Thừa"},
        {id: 'HBYirj2c_jw', song: 'Deadpool 2 - Take on Me'},
        {id: '8WYHDfJDPDc', song: 'Nelly - Dilemma ft. Kelly Rowland (Official Video)'},
        {id: 'uelHwf8o7_U', song: 'Eminem - Love The Way You Lie ft. Rihanna'},
        {id: 'WpYeekQkAdc', song: 'The Black Eyed Peas - Where Is The Love?'}
    ];
    constructor() { }
    find(id: string) {
        return this.playlist.find(item => item.id === id);
    }
}