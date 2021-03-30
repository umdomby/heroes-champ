<template>
  <v-container fluid grid-list-xl>

<!--    <v-layout row>-->
<!--      <input type="text" v-on:input="edit">-->
<!--      <div>{{data}}</div>-->
<!--    </v-layout>-->
<!--    <v-btn v-on:click="data++">кнопка</v-btn>-->

<!--    <championship-list v-if="profile"></championship-list>-->

  </v-container>
</template>

<script>
import {mapState} from 'vuex'
import ChampionshipList from "../components/championships/ChampionshipList.vue";


export default {

  components: {
    ChampionshipList
  },
  data() {
    return {
      data: '222',
    }
  },
  computed: mapState(['profile']),
  methods:{
    edit(event){
      this.data = event.target.value
    }
  }

 }
</script>

<style>

</style>
