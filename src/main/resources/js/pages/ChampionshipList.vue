<template>
  <v-container fluid grid-list-xl>
<!--&lt;!&ndash;    <v-layout align-space-around justify-start column>&ndash;&gt;-->
<!--&lt;!&ndash;      <div v-for="user in sortedUsers">&ndash;&gt;-->
<!--&lt;!&ndash;        &lt;!&ndash;        {{ user.id }} &ndash;&gt;&ndash;&gt;-->
<!--&lt;!&ndash;        {{ user.name }}&ndash;&gt;-->
<!--&lt;!&ndash;      </div>&ndash;&gt;-->
<!--&lt;!&ndash;    </v-layout>&ndash;&gt;-->

<!--    <v-layout row wrap>-->
<!--      <v-flex v-for="user in sortedUsers" xs3>-->
<!--        <v-card dark color="secondary" >-->
<!--          <v-card-text class="px-2">{{ user.name }}</v-card-text>-->
<!--        </v-card>-->
<!--      </v-flex>-->
<!--    </v-layout>-->
<!--    <br>-->
<!--    <v-layout align-space-around justify-start column>-->
<!--      <champ-form :champAttr="champ" />-->
<!--      <champ-row  v-for="champ in sortedChamps"-->
<!--                   :key="champ.id"-->
<!--                   :champ="champ"-->
<!--                   :editChamp="editChamp" />-->
<!--    </v-layout>-->


    <v-layout row wrap>
      <v-flex v-for="champions in sortedChampionships" xs3>
        <v-card dark color="secondary" >
          <v-card-text class="px-2">Type: {{champions.name}}; start: {{champions.date}}</v-card-text>
        </v-card>
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script>
import { mapGetters } from 'vuex'
// import ChampionshipListForm from '../components/championships/ChampionshipList.vue'
// import ChampionshipListRow from '../components/championships/ChampionshipRow'

export default {
  components: {
    // ChampionshipListRow,
    // ChampionshipListForm
  },
  data() {
    return {
      // champ: null,
      user: null,
      // name: '',
    }
  },
   computed: mapGetters(['sortedChampionships','sortedUsers']),

  // methods: {
  //   editChamp(champ) {
  //     this.champ = champ
  //   }
  // }
 }
</script>

<style>

</style>
