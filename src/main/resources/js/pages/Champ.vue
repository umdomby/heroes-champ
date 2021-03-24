<template>
  <v-container fluid grid-list-xl>
<!--    <v-layout align-space-around justify-start column>-->
<!--      <div v-for="user in sortedUsers">-->
<!--        &lt;!&ndash;        {{ user.id }} &ndash;&gt;-->
<!--        {{ user.name }}-->
<!--      </div>-->
<!--    </v-layout>-->

<!--    <v-layout row wrap>-->
<!--      <v-flex v-for="user in sortedUsers" xs3>-->
<!--        <v-card dark color="secondary" >-->
<!--          <v-card-text class="px-2">{{ user.name }}</v-card-text>-->
<!--        </v-card>-->
<!--      </v-flex>-->
<!--    </v-layout>-->

    <br>
    <v-layout align-space-around justify-start column>
      <champ-form :champAttr="champ" />
      <champ-row  v-for="champ in sortedChamps"
                   :key="champ.id"
                   :champ="champ"
                   :editChamp="editChamp" />
    </v-layout>
  </v-container>
</template>

<script>
import { mapGetters } from 'vuex'
import ChampRow from '../components/champs/ChampRow.vue'
import ChampForm from '../components/champs/ChampForm.vue'

export default {
  components: {
    ChampRow,
    ChampForm
  },
  data() {
    return {
      champ: null,
      user: null,
      name: '',
    }
  },
  computed: mapGetters(['sortedChamps','sortedUsers']),

  methods: {
    editChamp(champ) {
      this.champ = champ
    }
  }
}
</script>

<style>

</style>
