import Vue from 'vue'
import VueRouter from 'vue-router'
import MessagesList from '../pages/MessageList.vue'
import Auth from '../pages/Auth.vue'
import Profile from '../pages/Profile.vue'
import Subscriptions from '../pages/Subscriptions.vue'

import Main from '../pages/Main.vue'
import Contact from '../pages/Contact.vue'

Vue.use(VueRouter)

const routes = [
    { path: '/message', component: MessagesList },
    { path: '/auth', component: Auth },
    { path: '/user/:id?', component: Profile },
    { path: '/subscriptions/:id', component: Subscriptions },
    { path: '*', component: MessagesList },
    { path: '/', component: Main },
    { path: '/Contact', component: Contact },
]

export default new VueRouter({
    mode: 'history',
    routes
})
