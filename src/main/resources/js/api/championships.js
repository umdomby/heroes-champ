import Vue from 'vue'

const championships = Vue.resource('/championship{/id}')

export default {
    add: championship => championships.save({}, championship),
    update: championship => championships.update({id: championship.id}, championship),
}
