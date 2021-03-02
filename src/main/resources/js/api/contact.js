import Vue from 'vue'

const contacts = Vue.resource('/contact{/id}')

export default {
    add: contact => contacts.save({}, contact),
    update: contact => contacts.update({id: contact.id}, contact),
    remove: id => contacts.remove({id}),
    page: page => Vue.http.get('/contact', {params: { page }})
}
