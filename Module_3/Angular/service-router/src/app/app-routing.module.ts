import { NgModule } from '@angular/core';
import { Routes, RouterModule, PreloadAllModules } from '@angular/router';


import {TimelinesComponent} from './timelines/timelines.component'
import { Timelines2Component } from './timelines2/timelines2.component';
import { YoutubePlaylistComponent } from './youtube-playlist/youtube-playlist.component';
import { YoutubePlayerComponent } from './youtube-player/youtube-player.component';
import { DictionaryPageComponent } from './dictionary-page/dictionary-page.component';
import { DictionaryDetailComponent } from './dictionary-detail/dictionary-detail.component';

const routes: Routes = [    
  {
    path: 'timelines',
    component: TimelinesComponent
  },
  {
    path: 'timelines2',
    component: Timelines2Component
  },
  {
    path: 'youtube',component: YoutubePlaylistComponent,
    children: [{
        path: ':id',
        component: YoutubePlayerComponent
    }]
  },
  { 
    path: 'dictionary', component : DictionaryPageComponent,
    children: [{
        path: ':key',
        component: DictionaryDetailComponent   
    }]
  },
  // {
  //   path: 'blog',
  //   loadChildren: './blog/blog.module#BlogModule'
  // }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {
    preloadingStrategy: PreloadAllModules
  })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
