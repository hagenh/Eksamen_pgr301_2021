
import http from 'k6/http';
import { sleep } from 'k6';

export const options = {
  thresholds: {
    http_req_duration: ['p(95)<500'],
  },
  duration: '1m',
  vus: 50
};

export default function () {

  const res = http.get('https://test.k6.io');
  sleep(1);
}