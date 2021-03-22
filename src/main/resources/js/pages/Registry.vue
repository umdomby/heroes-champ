<template>

  <v-container fluid grid-list-xl>

    <v-footer class="pa-3 justify-center" >
      <div>&copy; {{ new Date().getDate() }}.{{ new Date().getMonth() }}.{{ new Date().getFullYear() }}
      </div>
    </v-footer>

<!--    <v-layout row wrap>-->
<!--&lt;!&ndash;      <v-flex xs12>&ndash;&gt;-->
<!--&lt;!&ndash;        <v-card dark color="primary">&ndash;&gt;-->
<!--&lt;!&ndash;          <v-card-text class="px-0">12</v-card-text>&ndash;&gt;-->
<!--&lt;!&ndash;        </v-card>&ndash;&gt;-->
<!--&lt;!&ndash;      </v-flex>&ndash;&gt;-->
<!--      <v-flex v-for="user in sortedUsers" xs3>-->
<!--        <v-card dark color="secondary" >-->
<!--          <v-card-text class="px-2">{{ user.name }}</v-card-text>-->
<!--        </v-card>-->
<!--      </v-flex>-->

<!--    </v-layout>-->


<!--    <v-layout align-space-around justify-start column>-->
<!--      <div v-for="user in sortedUsers">-->
<!--        &lt;!&ndash;        {{ user.id }} &ndash;&gt;-->
<!--        {{ user.name }}-->
<!--      </div>-->
<!--    </v-layout>-->

    <v-layout align-space-around justify-start column>
      <div v-for="person in sortedPerson">
        <!--        {{ user.id }} -->
        {{ person.nickname }} rate:{{ person.rate }} info:{{ person.social_network_1 }}
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
