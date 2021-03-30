import Vue from 'vue'
import VueRouter from 'vue-router'
import MessagesList from '../pages/MessageList.vue'
import Auth from '../pages/Auth.vue'
import Profile from '../pages/Profile.vue'
import Subscriptions from '../pages/Subscriptions.vue'

import Main from '../pages/Main.vue'
import ChampList from '../pages/ChampList.vue'
import Person from '../pages/Person.vue'

Vue.use(VueRouter)

const routes = [
    { path: '/', component: MessagesList },
    { path: '/auth', component: Auth },
    { path: '/user/:id?', component: Profile },
    { path: '/subscriptions/:id', component: Subscriptions },
    { path: '*', component: MessagesList },
    { path: '/main', component: Main },
    { path: '/ch', component: ChampList},
    { path: '/pr', component: Person},
]

export default new VueRouter({
    mode: 'history',
    routes
})
