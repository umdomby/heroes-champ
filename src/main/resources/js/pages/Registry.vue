<template>

  <v-container fluid grid-list-xl>

    <v-layout>
      <form class="card">
        <h2>Settings account</h2>
        <div class="form-control">
          <label for="name">Name:</label>
          <input type="text" id="name" v-model.trim="name">
        </div>
        <button class="btn primary" :disabled="name.length === 0">Add login Heroes</button>
      </form>
    </v-layout>

    <v-footer class="pa-3 justify-center" >
      <div>&copy; {{ new Date().getDate() }}.{{ new Date().getMonth() }}.{{ new Date().getFullYear() }}
      </div>
    </v-footer>

    <v-layout row wrap>
<!--      <v-flex xs12>-->
<!--        <v-card dark color="primary">-->
<!--          <v-card-text class="px-0">12</v-card-text>-->
<!--        </v-card>-->
<!--      </v-flex>-->
      <v-flex v-for="user in sortedUsers" xs3>
        <v-card dark color="secondary" >
          <v-card-text class="px-2">{{ user.name }}</v-card-text>
        </v-card>
      </v-flex>

    </v-layout>


    <v-layout align-space-around justify-start column>
      <div v-for="user in sortedUsers">
        <!--        {{ user.id }} -->
        {{ user.name }}
      </div>
    </v-layout>

    <v-layout align-space-around justify-start column>
      <div v-for="person in sortedPerson">
        <!--        {{ user.id }} -->
        {{ person.nickname }}
      </div>
    </v-layout>


  </v-container>

</template>

<script>

import {mapGetters} from 'vuex'
// import PersonList from "../components/person/PersonList";


export default {
  name: 'Registry',
  data() {
    return {
      user: null,
      name: '',
      person: ''
    }
  },
  computed: mapGetters(
      ['sortedUsers', "sortedPerson"]
  ),
  // components: {
  //   PersonList
  // }

}
</script>

<style scoped>

</style>
