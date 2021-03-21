<template>
  <v-container>
    <v-layout align-space-around justify-start column>
      <champ-form :champAttr="champ" />
      <champ-row v-for="champ in sortedChamps"
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
      champ: null
    }
  },
  computed: mapGetters(['sortedChamps']),
  methods: {
    editChamp(champ) {
      this.champ = champ
    }
  }
}
</script>

<style>

</style>
