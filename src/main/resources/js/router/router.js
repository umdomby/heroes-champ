import Vue from 'vue'
import VueRouter from 'vue-router'
import MessagesList from '../pages/MessageList.vue'
import Auth from '../pages/Auth.vue'
import Profile from '../pages/Profile.vue'
import Subscriptions from '../pages/Subscriptions.vue'
import Main from '../pages/Main.vue'
import Champ from '../pages/Champ.vue'
import Registry from '../pages/Registry.vue'
import Championship from '../pages/Championship.vue'

Vue.use(VueRouter)

const routes = [
    { path: '/', component: MessagesList },
    { path: '/auth', component: Auth },
    { path: '/user/:id?', component: Profile },
    { path: '/subscriptions/:id', component: Subscriptions },
    { path: '*', component: MessagesList },
    { path: '/main', component: Main },
    { path: '/ch', component: Champ},
    { path: '/registry', component: Registry},
    { path: '/championships', component: Championship},
]

export default new VueRouter({
    mode: 'history',
    routes
})
