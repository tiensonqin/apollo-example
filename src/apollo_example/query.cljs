(ns apollo-example.query)

(def query-json (js/JSON.parse "{
  \"kind\": \"Document\",
  \"definitions\": [
    {
      \"kind\": \"OperationDefinition\",
      \"operation\": \"query\",
      \"name\": {
        \"kind\": \"Name\",
        \"value\": \"GetPokemon\",
        \"loc\": {
          \"start\": 8,
          \"end\": 18
        }
      },
      \"variableDefinitions\": [
        {
          \"kind\": \"VariableDefinition\",
          \"variable\": {
            \"kind\": \"Variable\",
            \"name\": {
              \"kind\": \"Name\",
              \"value\": \"name\",
              \"loc\": {
                \"start\": 20,
                \"end\": 24
              }
            },
            \"loc\": {
              \"start\": 19,
              \"end\": 24
            }
          },
          \"type\": {
            \"kind\": \"NonNullType\",
            \"type\": {
              \"kind\": \"NamedType\",
              \"name\": {
                \"kind\": \"Name\",
                \"value\": \"String\",
                \"loc\": {
                  \"start\": 26,
                  \"end\": 32
                }
              },
              \"loc\": {
                \"start\": 26,
                \"end\": 32
              }
            },
            \"loc\": {
              \"start\": 26,
              \"end\": 33
            }
          },
          \"defaultValue\": null,
          \"loc\": {
            \"start\": 19,
            \"end\": 33
          }
        }
      ],
      \"directives\": [],
      \"selectionSet\": {
        \"kind\": \"SelectionSet\",
        \"selections\": [
          {
            \"kind\": \"Field\",
            \"alias\": null,
            \"name\": {
              \"kind\": \"Name\",
              \"value\": \"pokemon\",
              \"loc\": {
                \"start\": 41,
                \"end\": 48
              }
            },
            \"arguments\": [
              {
                \"kind\": \"Argument\",
                \"name\": {
                  \"kind\": \"Name\",
                  \"value\": \"name\",
                  \"loc\": {
                    \"start\": 49,
                    \"end\": 53
                  }
                },
                \"value\": {
                  \"kind\": \"Variable\",
                  \"name\": {
                    \"kind\": \"Name\",
                    \"value\": \"name\",
                    \"loc\": {
                      \"start\": 56,
                      \"end\": 60
                    }
                  },
                  \"loc\": {
                    \"start\": 55,
                    \"end\": 60
                  }
                },
                \"loc\": {
                  \"start\": 49,
                  \"end\": 60
                }
              }
            ],
            \"directives\": [],
            \"selectionSet\": {
              \"kind\": \"SelectionSet\",
              \"selections\": [
                {
                  \"kind\": \"Field\",
                  \"alias\": null,
                  \"name\": {
                    \"kind\": \"Name\",
                    \"value\": \"name\",
                    \"loc\": {
                      \"start\": 70,
                      \"end\": 74
                    }
                  },
                  \"arguments\": [],
                  \"directives\": [],
                  \"selectionSet\": null,
                  \"loc\": {
                    \"start\": 70,
                    \"end\": 74
                  }
                },
                {
                  \"kind\": \"Field\",
                  \"alias\": null,
                  \"name\": {
                    \"kind\": \"Name\",
                    \"value\": \"image\",
                    \"loc\": {
                      \"start\": 81,
                      \"end\": 86
                    }
                  },
                  \"arguments\": [],
                  \"directives\": [],
                  \"selectionSet\": null,
                  \"loc\": {
                    \"start\": 81,
                    \"end\": 86
                  }
                }
              ],
              \"loc\": {
                \"start\": 62,
                \"end\": 92
              }
            },
            \"loc\": {
              \"start\": 41,
              \"end\": 92
            }
          }
        ],
        \"loc\": {
          \"start\": 35,
          \"end\": 96
        }
      },
      \"loc\": {
        \"start\": 2,
        \"end\": 96
      }
    }
  ],
  \"loc\": {
    \"start\": 0,
    \"end\": 96
  }
}"))
