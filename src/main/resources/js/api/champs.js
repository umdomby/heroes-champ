import Vue from 'vue'

const champs = Vue.resource('/champ{/id}')

export default {
    add: champ => champs.save({}, champ),
    update: champ => champs.update({id: champ.id}, champ),
    remove: id => champs.remove({id})
}

