#!/bin/bash


function env_to_pro() {
    local env="$1"
    local elements=$(echo "$line" | tr "_" ".")
    echo "$elements"
}

while IFS= read -r line; do

  elements=$(echo "$line" | tr "=" "\n")
  len=${#elements[@]}
  echo $#elements[0]
  echo $(env_to_pro "$element")

  echo $len
  for element in $elements
  do
    echo "$element"
    ret=$(env_to_pro "$element")
  done
  cat -
#  printf '%s\n' "$line"
done
