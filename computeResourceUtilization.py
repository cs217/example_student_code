import sys
import json
import operator
import functools

def comp_size(bitWidth, dims, padding, nBuf):
    size = functools.reduce(operator.mul, [d + p for d, p in zip(dims, padding)])
    return size * bitWidth * nBuf


if __name__ == "__main__":
    with open(sys.argv[1]) as report_file:
        report = json.load(report_file)
    sizes = {
        "bram": 0,
        "reg": 0,
        "ops": report["fixed_ops"]
    }
    del report["fixed_ops"]
    for memory_type, data in report.items():
        for name, sizing in data.items():
            sizes[memory_type] += comp_size(*sizing)
    print(sizes)
